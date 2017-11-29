# nablarch-report-sample

| master | develop |
|:-----------|:------------|
|[![Build Status](https://travis-ci.org/nablarch/nablarch-report-sample.svg?branch=master)](https://travis-ci.org/nablarch/nablarch-report-sample)|[![Build Status](https://travis-ci.org/nablarch/nablarch-report-sample.svg?branch=develop)](https://travis-ci.org/nablarch/nablarch-report-sample)|


# 帳票サンプルアプリケーションを起動するために必要な作業
以下の手順に従って、サンプルアプリケーションを起動してください。

1. 帳票テンプレートのコンパイル。下記の２つ方法の内、いずれかを行ってください。  
  GradleのコンパイルタスクやIDEの機能を使ってビルドを実行する。

2. dbのセットアップ  
  Gradleのデータベースセットアップタスクを使用してデータベースのセットアップを行う。
  ```sh
  ./gradlew setupDb
  ```

3. アプリケーションの起動  
  GradleのjettyRunタスクを使用してアプリケーションの起動を行う
  ```sh
  ./gradlew jettyRun
  ```

4. ログイン情報  
  ログインID: ``nablarch``  
  パスワード: ``password``  


# 依存モジュール一覧

## compile
* com.nablarch.profile:nablarch-web
* com.nablarch.framework:nablarch-common-date
* com.nablarch.framework:nablarch-fw-batch
* com.nablarch.framework:nablarch-common-exclusivecontrol-jdbc
* com.nablarch.framework:nablarch-common-dao
* com.nablarch.framework:nablarch-common-code-jdbc
* com.nablarch.framework:nablarch-common-auth-jdbc
* com.nablarch.framework:nablarch-common-idgenerator-jdbc
* com.nablarch.framework:nablarch-common-auth
* com.nablarch.framework:nablarch-common-auth-jdbc
* com.nablarch.framework:nablarch-fw-messaging-http
* com.nablarch.framework:nablarch-backward-compatibility
* net.sf.jasperreports:jasperreports:5.6.1
  
* javax.mail:mailapi:1.4.3

## runtime
* com.oracle:ucp:11.2.0.3.0
* com.oracle:ojdbc6:11.2.0.4.0
* com.lowagie:iTextAsian:1.0.0


## test
* com.nablarch.framework:nablarch-testing
