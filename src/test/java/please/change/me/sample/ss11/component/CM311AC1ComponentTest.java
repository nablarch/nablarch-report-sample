package please.change.me.sample.ss11.component;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import nablarch.core.ThreadContext;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.statement.SqlRow;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.Message;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.test.core.db.DbAccessTestSupport;

import org.junit.Test;

import please.change.me.sample.ss11.entity.SystemAccountEntity;
import please.change.me.sample.ss11.entity.UgroupSystemAccountEntity;
import please.change.me.sample.ss11AC.W11AC02Form;

/**
 * {@link CM311AC1Component} のクラス単体テスト
 *
 * @author T.Kawasaki
 */
public class CM311AC1ComponentTest extends DbAccessTestSupport {

    /** テスト対象クラス */
    private CM311AC1Component sut = new CM311AC1Component();

    @Test
    public void グループ取得_全グループIDと名称を取得できること() {
        final String sheetName = "グループ取得_全グループIDと名称を取得できること";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 実行
            SqlResultSet actual = sut.getUserGroups();
            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }

    @Test
    public void グループ取得_グループが1件も存在しない場合に空の結果セットを取得できること() {
        final String sheetName = "グループ取得_グループが1件も存在しない場合";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 実行
            SqlResultSet actual = sut.getUserGroups();
            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }

    @Test
    public void 認可単位取得_全認可単位を取得できること() {
        final String sheetName = "認可単位取得_全認可単位を取得できること";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 実行
            SqlResultSet actual = sut.getAllPermissionUnit();

            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }


    @Test
    public void 認可単位取得_認可単位が1件も存在しない場合に空の結果セットを取得できること() {
        final String sheetName = "認可単位取得_認可単位が1件も存在しない場合";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 実行
            SqlResultSet actual = sut.getAllPermissionUnit();

            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }

    @Test
    public void グループID存在チェック_グループIDの存在チェックができること() {
        final String sheetName = "グループID存在チェック_グループIDの存在チェック";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String ugroupId = shot.get("ugroupId");
            UgroupSystemAccountEntity entity = new UgroupSystemAccountEntity();
            entity.setUgroupId(ugroupId);

            // 実行
            boolean actual = sut.existGroupId(entity);

            // 検証
            boolean expected = Boolean.valueOf(shot.get("expected"));
            assertEquals(message, actual, expected);
        }
    }

    @Test
    public void 認可単位ID存在チェック_認可単位の存在チェックができること() {
        final String sheetName = "認可単位ID存在チェック_認可単位の存在チェック";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String[] input = split(shot.get("permissionUnitId"));
            SystemAccountEntity entity = new SystemAccountEntity();
            entity.setPermissionUnit(input);

            // 実行
            boolean actual = sut.existPermissionUnitId(entity);

            // 検証
            boolean expected = Boolean.valueOf(shot.get("expected"));
            assertEquals(message, actual, expected);
        }
    }

    @Test
    public void ユーザ基本情報検索_指定したユーザの情報を取得できること() {
        final String sheetName = "ユーザ基本情報検索_指定したユーザの情報を取得";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            SqlResultSet actual = sut.selectUserBasicInfo(userId);

            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }

    @Test
    public void ユーザ詳細情報検索_指定したユーザの情報を取得できること() {
        final String sheetName = "ユーザ詳細情報検索_指定したユーザの情報を取得";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            SqlRow actual = sut.selectDetailedUserInfo(userId);

            // 検証
            String id = shot.get("expected");
            if (id == null) {
                assertNull(message, actual);
            } else {
                assertSqlRowEquals(message,
                                   sheetName,
                                   id,
                                   actual);
            }
        }
    }


    @Test
    public void 認可単位検索_指定したユーザの認可単位を取得できること() {
        final String sheetName = "認可単位検索_指定したユーザの認可単位を取得";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            SqlResultSet actual = sut.selectPermissionUnit(userId);

            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }


    @Test
    public void グループ検索_指定したユーザのグループを取得できること() {
        final String sheetName = "グループ検索_指定したユーザのグループを取得";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            SqlResultSet actual = sut.selectUgroup(userId);

            // 検証
            assertSqlResultSetEquals(message,
                                     sheetName,
                                     shot.get("expected"),
                                     actual);
        }
    }

    @Test
    public void ユーザ削除_指定したユーザの情報を削除できること() {
        final String sheetName = "ユーザ削除_指定したユーザの情報を削除できること";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            sut.deleteUser(userId);
            commitTransactions();

            // 検証
            assertTableEquals(message, sheetName, shot.get("expected"));

        }

    }


    @Test
    public void システムアカウント権限情報削除_指定したユーザの情報を削除できること() {
        final String sheetName = "システムアカウント権限情報削除_指定したユーザの情報を削除";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        for (Map<String, String> shot : shots) {

            String message = sheetName + "：shot[" + shot.get("no") + "] " + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            // 入力パラメータ準備
            String userId = shot.get("userId");

            // 実行
            sut.deleteSystemAccountAuthority(userId);
            commitTransactions();

            // 検証
            assertTableEquals(message, sheetName, shot.get("expected"));

        }
    }


    /**
     * 与えられた文字列をカンマで区切る。
     *
     * @param orig 分割対象の文字列
     * @return 分割後の文字列配列
     */
    private String[] split(String orig) {
        if (orig == null) {
            return null;
        }
        if (orig.isEmpty()) {
            return new String[0];
        }
        return orig.split(",");
    }

    /**
     * メッセージのリストからメッセージIDを抽出する。
     * @param msgs メッセージのリスト
     * @return メッセージIDのリスト
     */
    private List<String> getMessageIdsOf(List<Message> msgs) {
        List<String> ids = new ArrayList<String>(msgs.size());
        for (Message msg : msgs) {
            ids.add(msg.getMessageId());
        }
        return ids;
    }

    /**
     * 入力パラメータからフォームへ変換する。
     *
     * @param params パラメータ
     * @return フォーム
     */
    private W11AC02Form convert(Map<String, String[]> params) {
        // 精査
        ValidationContext<W11AC02Form> context = ValidationUtil.validateAndConvertRequest("W11AC02", W11AC02Form.class, params,
                                                                                          "insert");
        context.abortIfInvalid();
        return context.createObject();
    }
}
