-------------------------------------------------------------------------------
-- システムアカウント検索用
-------------------------------------------------------------------------------
SELECT_SYSTEM_ACCOUNT =
SELECT
    SA.USER_ID,
    SA.LOGIN_ID,
    US.KANJI_NAME
FROM
    SYSTEM_ACCOUNT SA
INNER JOIN
    USERS US
ON
    SA.LOGIN_ID = ?
WHERE
    SA.USER_ID = US.USER_ID