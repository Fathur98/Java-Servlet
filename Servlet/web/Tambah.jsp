<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>TAMBAH NASABAH</title>
</head>
<body style="margin: 80px">
<h1 class="heading" style="text-align: center; padding: auto"><b>TAMBAH NASABAH</b></h1>
<form action="insert" method="post">
    <div class="form-group">
        <label for="name">NAMA NASABAH</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Masukkan nama nasabah">
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
        <label for="country">ALAMAT NASABAH</label>
        <input type="text" class="form-control" id="country" name="country" placeholder="Masukkan alamat nasabah">
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
        <label for="email">EMAIL NASABAH</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="Masukkan email nasabah">
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
        <button type="submit" name="submit" id="kirim" class="btn btn-primary">Kirim !</button>
        <a href="/">
            <button type="button" name="button" id="kembali" class="btn btn-primary">Kembali</button>
        </a>
    </div>
</form>
</body>
</html>

