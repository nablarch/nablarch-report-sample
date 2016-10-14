package please.change.me.sample.ss11.component;

import nablarch.core.db.statement.SqlPStatement;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.statement.SqlRow;
import nablarch.core.db.support.DbAccessSupport;
import please.change.me.sample.ss11.entity.SystemAccountEntity;
import please.change.me.sample.ss11.entity.UgroupSystemAccountEntity;

/**
 * ユーザ管理機能に関する機能内共通コンポーネント（設計書なし）
 * 
 * @author Hiroto Nitta
 */
public class CM311AC1Component extends DbAccessSupport {

    /**
     * グループテーブルに登録されている全てのグループIDと名称を取得する。
     * 
     * @return 検索結果
     */
    public SqlResultSet getUserGroups() {
        SqlPStatement statement = getSqlPStatement("SELECT_ALL_UGROUPS");
        return statement.retrieve();
    }

    /**
     * 認可単位テーブルに登録されている全ての認可単位IDと名称を取得する。
     * 
     * @return 検索結果。認可単位IDの昇順でソート
     */
    public SqlResultSet getAllPermissionUnit() {
        SqlPStatement statement = getSqlPStatement("SELECT_ALL_PERMISSION_UNITS");
        return statement.retrieve();
    }

    /**
     * グループIDがシステムに登録されているかチェックする。
     * 
     * @param ugroupSystemAccount チェック対象の情報を保持した{@link UgroupSystemAccountEntity}
     * @return グループIDがシステムに登録されていればtrue
     */
    public boolean existGroupId(UgroupSystemAccountEntity ugroupSystemAccount) {

        SqlPStatement statement = getSqlPStatement("CHECK_UGROUP");
        statement.setString(1, ugroupSystemAccount.getUgroupId());
        SqlResultSet result = statement.retrieve();
        return !result.isEmpty();
    }

    /**
     * 認可単位IDがシステムに登録されているかチェックする。
     * 引数で与えられたシステムアカウントの認可単位ID全てが
     * 登録されている場合、真が返却される。
     * 認可単位がnullまたは要素数0の場合は、存在チェック対象外とし、
     * 真が返却される。
     *
     * @param systemAccount チェック対象の情報を保持した{@link SystemAccountEntity}
     * @return 認可単位IDがシステムに登録されていればtrue
     */
    public boolean existPermissionUnitId(SystemAccountEntity systemAccount) {
        String[] permissionUnit = systemAccount.getPermissionUnit();
        if (permissionUnit == null) {
            return true;
        }
        SqlPStatement statement = getSqlPStatement("CHECK_PERMISSION_UNIT");
        for (String permissionUnitId : permissionUnit) {
            statement.setString(1, permissionUnitId);
            SqlResultSet result = statement.retrieve();
            if (result.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 対象ユーザの基本情報を検索する。
     * 
     * @param userId 検索条件（ユーザID）
     * @return 検索結果
     */
    SqlResultSet selectUserBasicInfo(String userId) {
        SqlPStatement statement = getSqlPStatement("SELECT_USER_BASIC_INFO");
        statement.setString(1, userId);

        return statement.retrieve();
    }

    /**
     * 指定されたユーザIDに紐づく、ユーザ情報を取得する。
     *
     * 取得する情報は以下の通り。
     *
     * <ul>
     *   <li>システムアカウント情報</li>
     *   <li>ユーザ基本情報</li>
     *   <li>グループID</li>
     * </ui>
     *
     * 指定されたユーザIDが存在しない場合には、{@code null} を返却する。
     *
     * @param userId 取得対象のユーザID
     * @return ユーザの詳細情報。ユーザが存在しない場合は {@code null}
     */
    public SqlRow selectDetailedUserInfo(String userId) {
        // 更新対象ユーザ情報の取得
        SqlPStatement statement = getSqlPStatement("SELECT_DETAILED_USER_INFO");
        statement.setString(1, userId);
        SqlResultSet userInfoSet = statement.retrieve();

        if (userInfoSet.isEmpty()) {
            return null;
        }

        return userInfoSet.get(0);
    }

    /**
     * 対象ユーザに紐づいた権限情報を認可単位テーブルから検索する。<br/>
     * 取得するデータは、認可単位IDと認可単位名称
     * 
     * @param userId 検索条件（ユーザID）
     * @return 検索結果
     */
    public SqlResultSet selectPermissionUnit(String userId) {
        SqlPStatement statement = getSqlPStatement("SELECT_PERMISSION_UNIT");
        statement.setString(1, userId);

        return statement.retrieve();
    }

    /**
     * 対象ユーザの権限情報をグループテーブルから検索する。<br/>
     * 取得するデータは、グループIDとグループ名称
     * 
     * @param userId 検索条件（ユーザID）
     * @return 検索結果
     */
    public SqlResultSet selectUgroup(String userId) {
        SqlPStatement statement = getSqlPStatement("SELECT_UGROUP");
        statement.setString(1, userId);

        return statement.retrieve();
    }

    /**
     * 指定されたユーザIDに紐づくユーザ情報を削除する。
     * 
     * @param userId 削除対象ユーザID
     */
    void deleteUser(String userId) {

        // システムアカウントテーブルデータの削除
        SqlPStatement statement = getSqlPStatement("DELETE_SYSTEM_ACCOUNT");
        statement.setString(1, userId);
        statement.execute();

        // ユーザテーブルデータの削除
        statement = getSqlPStatement("DELETE_USERS");
        statement.setString(1, userId);
        statement.execute();

        // グループシステムアカウントテーブルデータの削除
        statement = getSqlPStatement("DELETE_UGROUP_SYSTEM_ACCOUNT");
        statement.setString(1, userId);
        statement.execute();

        // システムアカウント権限テーブルデータの削除
        deleteSystemAccountAuthority(userId);
    }

    /**
     * 指定されたユーザIDに紐づくシステムアカウント権限情報を削除する。
     * 
     * @param userId 削除対象のユーザID
     */
    void deleteSystemAccountAuthority(String userId) {
        SqlPStatement statement;
        statement = getSqlPStatement("DELETE_SYSTEM_ACCOUNT_AUTHORITY");
        statement.setString(1, userId);
        statement.execute();
    }
}
