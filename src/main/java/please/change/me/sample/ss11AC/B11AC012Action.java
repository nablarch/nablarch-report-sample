package please.change.me.sample.ss11AC;

import java.util.HashMap;
import java.util.Map;

import nablarch.common.io.FileRecordWriterHolder;
import nablarch.core.date.SystemTimeUtil;
import nablarch.core.db.statement.SqlPStatement;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.statement.SqlRow;
import nablarch.fw.DataReader;
import nablarch.fw.ExecutionContext;
import nablarch.fw.Result;
import nablarch.fw.Result.Success;
import nablarch.fw.action.BatchAction;
import nablarch.fw.launcher.CommandLine;
import nablarch.fw.reader.DatabaseRecordReader;
import nablarch.integration.report.ReportContext;
import nablarch.integration.report.ReportManager;
import nablarch.integration.report.ReportParam;
import nablarch.integration.report.datasource.SqlResultSetDataSource;

/**
 * 削除ユーザレポートテンポラリの情報を固定長ファイルに出力する。
 * <p/>
 * 同時に削除ユーザーの一覧をPDF帳票として出力する。 <br />
 * 
 * ※本バッチアクションは、ファイルへの出力順（ユーザIDの昇順）があるため、 マルチスレッドでの実行はNGである。
 * （マルチスレッドで実行すると、ファイルへの出力順が保証されない。)
 * 
 * 
 * 
 * @author Naoki Tamura
 */
public class B11AC012Action extends BatchAction<SqlRow> {

    /** ファイルID */
    private static final String FILE_ID = "N11AA001";

    /** データレコードのレコード数 */
    private int dataRecordCount;

    /**
     * {@inheritDoc}
     * <p/>
     * ヘッダーレコードを出力する。
     */
    @Override
    protected void initialize(CommandLine command, ExecutionContext context) {
        FileRecordWriterHolder.open(FILE_ID, FILE_ID);

        // ヘッダー行の出力
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("sysDate", SystemTimeUtil.getDateString());
        writeRecord("header", header);

        dataRecordCount = 0;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * 削除ユーザレポートテンポラリから取得したレコードをデータレコードに出力する。
     */
    @Override
    public Result handle(SqlRow inputData, ExecutionContext context) {

        // データレコードを出力
        writeRecord("data", inputData);

        // 総件数のインクリメント
        dataRecordCount++;

        return new Success();
    }

    /**
     * {@inheritDoc}
     * <p/>
     * トレーラレコードと、エンドレコードを出力し削除ユーザーの一覧を帳票として出力する。
     */
    @Override
    protected void terminate(Result result, ExecutionContext context) {

        if (result.isSuccess()) {
            writeTrailerRecord();
            writeEndRecord();

            // 削除ユーザー一覧帳票を出力する
            SqlPStatement statement = getSqlPStatement("GET_OUTPUT_FILE_DATA");
            SqlResultSet resultSet = statement.retrieve();

            ReportParam param;
            if (!resultSet.isEmpty()) {
                param = new ReportParam(new Object(), new SqlResultSetDataSource(
                        resultSet));
            } else {
                param = new ReportParam(null);
            }
            ReportContext ctx = new ReportContext("R003");
            ctx.addReportParam(param);
            ReportManager.createReport(ctx);

        }
    }

    /** トレーラレコードを出力する。 */
    private void writeTrailerRecord() {
        Map<String, Object> trailer = new HashMap<String, Object>();
        trailer.put("totalCount", dataRecordCount);
        writeRecord("trailer", trailer);
    }

    /** エンドレコードを出力する。 */
    private void writeEndRecord() {
        writeRecord("end", new HashMap<String, Object>(0));
    }

    /**
     * {@inheritDoc} ファイル出力対象のデータを読み込む{@link DatabaseRecordReader}を生成する。
     */
    @Override
    public DataReader<SqlRow> createReader(ExecutionContext ctx) {

        int count = countByStatementSql("GET_OUTPUT_FILE_DATA");
        writeLog("M000000001", count);

        DatabaseRecordReader reader = new DatabaseRecordReader();
        SqlPStatement statement = getSqlPStatement("GET_OUTPUT_FILE_DATA");
        reader.setStatement(statement);
        return reader;

    }

    /**
     * ファイル出力処理。 指定されたMapを1レコードとしてファイル出力を行う。
     * 
     * @param recordType
     *            レコードタイプを表す文字列
     * @param record
     *            1レコードの情報を格納したMap
     */
    private static void writeRecord(String recordType, Map<String, ?> record) {
        FileRecordWriterHolder.write(recordType, record, FILE_ID);
    }
}
