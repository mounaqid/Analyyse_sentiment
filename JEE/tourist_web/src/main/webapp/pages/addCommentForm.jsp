<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts, Spring Hibernate App</title>
<sj:head jquerytheme="redmond" />

</head>
<body>
	<div align="center">

		<div>
			<s:if test="hasActionMessages()">
				<div class="messages">
					<s:actionmessage />
				</div>
			</s:if>
		</div>

		<h2>Ajouter un commentaire</h2>


		<s:form action="addComment" method="post">

			<div class="type-text">
				<s:textarea label="Veuillez écrire votre commentaire" name="userComment.text" cols="40" rows="10" />
			</div>
			<s:submit value="Enregistrer">
			</s:submit>

		</s:form>

	</div>
</body>
</html>