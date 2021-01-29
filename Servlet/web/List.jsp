<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #customers tr:hover {
        background-color: #ddd;
    }

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }
</style>
<head>
    <title>DAFTAR NASABAH</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="margin: 80px" class="container">
<h1 style="text-align: center"><b>DAFTAR NASABAH</b></h1>
<a href="<%=request.getContextPath()%>/new">
    <button type="button" class="btn btn-primary">TAMBAH NASABAH</button>
</a>
<br><br>
<table border="3" id="customers">
    <tr>
        <th style="text-align: center">AKSI</th>
        <th style="text-align: center">NO</th>
        <th style="text-align: center">NAMA</th>
        <th style="text-align: center">ALAMAT</th>
        <th style="text-align: center">EMAIL</th>
    </tr>
    <script>
        let i = 1;
    </script>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td style="text-align: center">
                <a href="edit?id=<c:out value='${user.id}' />">
                    <button type="button" class="btn btn-info">Ubah</button>
                </a>
                <a href="delete?id=<c:out value='${user.id}' />">
                    <button type="button" class="btn btn-danger">Hapus</button>
                </a>
            </td>
            <td style="text-align: center">
                <script>document.write(i)</script>
            </td>
            <td style="text-align: center"><c:out value="${user.name}"/></td>
            <td style="text-align: center"><c:out value="${user.country}"/></td>
            <td style="text-align: center"><c:out value="${user.email}"/></td>
            <script>
                i++;
            </script>
        </tr>
    </c:forEach>
</table>
</body>
</html>