<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <%/* --> <script src="js/devtool.js"></script><meta charset="utf-8"><body> <!-- */%> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field"  tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ taglib prefix="table"  tagdir="/WEB-INF/tags/widget/table" %>
<%@ taglib prefix="column" tagdir="/WEB-INF/tags/widget/column" %>
<%@ taglib prefix="spec" tagdir="/WEB-INF/tags/widget/spec" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="ユーザ情報一覧照会">

  <jsp:attribute name="contentHtml">
  <spec:layout name="ユーザ情報検索条件 入力欄">
  <n:form windowScopePrefixes="11AC_W11AC01">
    <field:block title="検索条件">
      <field:text
        title     = "ログインID"
        domain    = "LOGIN_ID"
        dataFrom  = "SYSTEM_ACCOUNT.LOGIN_ID"
        maxlength = "20"
        name      = "11AC_W11AC01.loginId">
      </field:text>

      <field:text
        title     = "漢字氏名"
        domain    = "KANJI_NAME"
        dataFrom  = "USERS.KANJI_NAME"
        maxlength = "20"
        name      = "11AC_W11AC01.kanjiName">
      </field:text>

      <field:text
        title     = "カナ氏名"
        domain    = "KANA_NAME"
        dataFrom  = "USERS.KANA_NAME"
        maxlength = "20"
        name      = "11AC_W11AC01.kanaName">
      </field:text>

      <field:pulldown
        title                = "グループ"
        name                 = "11AC_W11AC01.ugroupId"
        domain               = "UGROUP_ID"
        dataFrom             = "UGROUP.UGROUP_ID|UGROUP.UGROUP_NAME"
        listName             = "ugroupList"
        elementLabelProperty = "ugroupName"
        elementValueProperty = "ugroupId"
        withNoneOption       = "true"
        sample               = "[お客様グループ]|一般グループ">
      </field:pulldown>

      <field:code_pulldown
        title            = "ユーザIDロック"
        name             = "11AC_W11AC01.userIdLocked"
        codeId           = "C0000001"
        domain           = "C0000001"
        pattern          = "PATTERN01"
        optionColumnName = "OPTION01"
        labelPattern     = "$OPTIONALNAME$"
        withNoneOption   = "true">
      </field:code_pulldown>
    </field:block>

    <button:block>
      <button:search uri="/action/ss11AC/W11AC01Action/RW11AC0102" dummyUri="./W11AC0101.jsp">
        <n:param paramName="11AC_W11AC01.pageNumber" value="1"></n:param>
        <n:param paramName="11AC_W11AC01.sortId" value="1"></n:param>
      </button:search>
    </button:block>
  </n:form>
  </spec:layout>

  <n:form windowScopePrefixes="11AC_W11AC01">
    <spec:layout name="ユーザ情報検索結果">

    <table:search_result
      title               = "検索結果"
      searchUri           = "/action/ss11AC/W11AC01Action/RW11AC0102"
      listSearchInfoName  = "11AC_W11AC01"
      resultSetName       = "searchResult"
      sampleResults       = "15">

      <column:link
        title    = "ログインID"
        key      = "loginId"
        uri      = "/action/ss11AC/W11AC01Action/RW11AC0103"
        dummyUri = "./W11AC0102.jsp"
        domain   = "LOGIN_ID"
        dataFrom = "SYSTEM_ACCOUNT.LOGIN_ID"
        sample   = "user001|user002|user003">
        <n:param paramName="11AC_W11AC01.userId" name="row.userId"></n:param>
      </column:link>

      <column:label
        title    = "漢字氏名"
        key      = "kanjiName"
        sortable = "true"
        domain   = "KANJI_NAME"
        dataFrom = "USERS.KANJI_NAME"
        sample   = "名部　楽太郎|名部　楽次郎|名部　楽三郎|田嶋　岩魚">
      </column:label>

      <column:label
        title    = "カナ氏名"
        key      = "kanaName"
        sortable = "true"
        domain   = "KANA_NAME"
        dataFrom = "USERS.KANA_NAME"
        sample   = "ナブ　ラクタロウ|ナブ　ラクジロウ|ナブ　ラクサブロウ|タジマ　イワウオ">
      </column:label>

      <column:label
        title    = "グループ"
        key      = "ugroupName"
        domain   = "UGROUP_ID"
        dataFrom = "UGROUP.UGROUP_ID|UGROUP.UGROUP_NAME"
        sample   = "-|お客様グループ|一般グループ">
      </column:label>

      <column:label
        title    = "内線番号"
        key      = "extensionNumber"
        value    = "${row.extensionNumberBuilding} - ${row.extensionNumberPersonal}"
        domain   = "EXT_NUM_BUILDING|EXT_NUM_PERSONAL"
        dataFrom = "USERS.EXTENSION_NUMBER_BUILDING|USERS.EXTENSION_NUMBER_PERSONAL"
        sample   = "12-3456|98-7654">
      </column:label>

      <column:code
        title        = "ロック"
        key          = "userIdLocked"
        codeId       = "C0000001"
        labelPattern = "$OPTIONALNAME$"
        sample       = "-">
      </column:code>
    </table:search_result>

    <c:if test="${not empty resultCount}">
    <spec:desc>検索ボタン押下後</spec:desc>
    <button:block>

      <c:if test="${resultCount > 0}">
      <spec:desc>検索結果が1件以上あった場合</spec:desc>
      
      <button:download
        label    = "PDF出力"
        size     = "4"
        dummyUri = "./W11AC0101.jsp"
        uri      = "/action/ss11AC/W11AC01Action/RW11AC0105">
        <n:param paramName="11AC_W11AC01.pageNumber" value="1"></n:param>
        <n:param paramName="11AC_W11AC01.sortId" value="1"></n:param>
      </button:download>

      </c:if>

    </button:block>
    </c:if>

    </spec:layout>
  </n:form>
  </jsp:attribute>
</t:page_template>

