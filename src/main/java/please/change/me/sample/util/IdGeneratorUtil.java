package please.change.me.sample.util;

import nablarch.common.idgenerator.IdGenerator;
import nablarch.common.idgenerator.formatter.LpadFormatter;
import nablarch.core.repository.SystemRepository;

/**
 * 採番ユーティリティクラス。
 * 
 * @author Miki Habu
 */
public final class IdGeneratorUtil {

    /**
     * 隠蔽コンストラクタ。
     */
    private IdGeneratorUtil() {
    }

    /**
     * ユーザIDを採番する。
     * oracleシーケンス使用。
     * 
     * @return ユーザID(10桁左0パディング)
     */
    public static String generateUserId() {
        IdGenerator generator = (IdGenerator) SystemRepository.getObject("oracleSequenceIdGenerator");
        return generator.generateId("1101", new LpadFormatter(10, '0'));
    }

    /**
     * ユーザ情報IDを採番する。
     * oracleシーケンス使用。
     * 
     * @return ユーザ情報ID(20桁左0パディング)
     */
    public static String generateUserInfoId() {
        IdGenerator generator = (IdGenerator) SystemRepository.getObject("oracleSequenceIdGenerator");
        return generator.generateId("1102", new LpadFormatter(20, '0'));
    }
}
