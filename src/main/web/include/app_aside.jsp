<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/widget/link" %>

<n:form>
<ul>

  <%--
    ViewHandlerで設定される、現在選択中の取引ID（tid）に応じて、
    メニュー項目をハイライト表示する。
  --%>

  <n:set var="W11AB01current" value="${tid=='W11AB01' ? 'current' : ''}" />
  <li class="<n:write name='W11AB01current' /> hover">
    <link:submit
      uri="/action/ss11AB/W11AB01Action/RW11AB0101"
      dummyUri="./W11AB0101.jsp"
      label="">
      <i class="fa fa-list-alt"></i>ユーザー帳票出力
    </link:submit>
  </li>
</ul>
</n:form>
