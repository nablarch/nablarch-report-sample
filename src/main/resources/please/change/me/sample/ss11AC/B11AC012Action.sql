--------------------------------------------------------------------------------
-- ファイルへの出力対象のレコードを取得する。
--------------------------------------------------------------------------------
GET_OUTPUT_FILE_DATA =
SELECT
  USER_ID,
  LOGIN_ID,
  KANJI_NAME,
  KANA_NAME,
  MAIL_ADDRESS,
  EXTENSION_NUMBER_BUILDING,
  EXTENSION_NUMBER_PERSONAL,
  MOBILE_PHONE_NUMBER_AREA_CODE,
  MOBILE_PHONE_NUMBER_CITY_CODE,
  MOBILE_PHONE_NUMBER_SBSCR_CODE
FROM
  DELETE_USER_REPORT_TEMP
ORDER BY
  USER_ID

