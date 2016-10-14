--- report_sample sample application init
DROP USER report_sample CASCADE
;
DROP USER report_sample_test CASCADE
;
DROP USER report_sample_test_master CASCADE
;
--- report_sample tutorial application user
CREATE USER report_sample
      IDENTIFIED BY report_sample
             DEFAULT tablespace USERS
            TEMPORARY tablespace TEMP
;
CREATE USER report_sample_test
      IDENTIFIED BY report_sample_test
             DEFAULT tablespace USERS
            TEMPORARY tablespace TEMP
;
CREATE USER report_sample_test_master
      IDENTIFIED BY report_sample_test_master
             DEFAULT tablespace USERS
            TEMPORARY tablespace TEMP
;
GRANT DBA TO report_sample,report_sample_test,report_sample_test_master
;
