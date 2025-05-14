<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Elenco Docenti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list-docenti.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value='/home'/>">Gestione Docenti</a>
        <div class="d-flex">
            <a class="navbar-link" href="<c:url value='/home'/>">Home</a>
            <a class="navbar-link ms-3" href="<c:url value='/discenti/list'/>">Lista Discenti</a>
            <a class="navbar-link ms-3" href="<c:url value='/docenti/lista'/>">Lista Docenti</a>
            <a class="navbar-link ms-3" href="<c:url value='/corsi/list'/>">Lista Corsi</a>
            <a class="navbar-link ms-3" href="<c:url value='/docenti/new'/>">Nuovo Docente</a>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1>Elenco Docenti</h1>

    <form action="${pageContext.request.contextPath}/docenti/cerca" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="nome" class="form-control" placeholder="Cerca per nome" required>
            <button type="submit" class="btn btn-outline-primary">Cerca</button>
        </div>
    </form>

    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Azioni</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="d" items="${docenti}">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.nome}</td>
                    <td>${d.cognome}</td>
                    <td>
                        <a class="btn btn-sm btn-secondary" href="<c:url value='/docenti/${d.id}/edit'/>">Modifica</a>
                        <a class="btn btn-sm btn-danger" href="<c:url value='/docenti/${d.id}/delete'/>"
                           onclick="return confirm('Sei sicuro?')">Elimina</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h5>Totale Docenti: ${numDocenti}</h5>
    </div>
</div>

</body>
</html>
