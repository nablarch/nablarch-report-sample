package please.change.me.sample.util;

import static org.junit.Assert.*;
import nablarch.test.core.db.DbAccessTestSupport;

import org.junit.Test;

import please.change.me.sample.util.IdGeneratorUtil;

/**
 * {@link IdGeneratorUtil}のテストクラス
 * 
 * @author Miki Habu
 */
public class IdGeneratorUtilTest extends DbAccessTestSupport {

    /**
     * {@link please.change.me.tutorial.util.IdGeneratorUtil#generateUserId()}のテスト
     */
    @Test
    public void testGetUserId() {
        
        String sheetName = "getUserId";
        
        // データベース準備
        setUpDb(sheetName);
        
        assertEquals("0000000002", IdGeneratorUtil.generateUserId());
    }

    /**
     * {@link please.change.me.tutorial.util.IdGeneratorUtil#generateUserInfoId()}のテスト。
     */
    @Test
    public void testGetUserInfoId() {

        String sheetName = "getUserInfoId";

        // データベース準備
        setUpDb(sheetName);

        assertEquals("00000000000000000002", IdGeneratorUtil.generateUserInfoId());

    }

}
