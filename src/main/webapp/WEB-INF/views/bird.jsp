<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Birds API</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
</head>
<script>
    var service = 'http://localhost:8080/bird'

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestGetById = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestAdd = function (name, description, isCurban) {
        var JSONObject = {
            'name': name,
            'description': description,
            'isCurban': isCurban
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestUpdate = function (id, name, description, isCurban) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description,
            'isCurban': isCurban
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update/' + id,
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

</script>
<body>
<h1>Bird API</h1>
<table class="table table-bordered">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all birds - <strong>GET</strong></td>
        <td>/bird/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Get bird by id - <strong>GET</strong></td>
        <td>/bird/get/{id}</td>
        <td>
            id: <input id="getById" value="1"/>
            <button type="button" onclick="RestGetById($('#getById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add new bird - <strong>POST</strong></td>
        <td>/bird/add</td>
        <td>
            name: <input id="birdName" value="Kesha"/>
            description: <input id="birdDescription" value="colored"/>
            isCurban: <input id="birdCurban" value="true"/>
            <button type="button" onclick="RestAdd($('#birdName').val(), $('#birdDescription').val(), $('#birdCurban').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Update bird - <strong>PUT</strong></td>
        <td>/bird/update/id</td>
        <td>
            id: <input id="birdUpdateId" value="1"/>
            name: <input id="birdUpdateName" value="Kesha"/>
            description: <input id="birdUpdateDescription" value="colored"/>
            isCurban: <input id="birdUpdateCurban" value="true"/>
            <button type="button" onclick="RestUpdate($('#birdUpdateId').val(), $('#birdUpdateName').val(),
                $('#birdUpdateDescription').val(), $('#birdUpdateCurban').val())">Try</button>
        </td>
    </tr>
    <tr class="table-primary">
        <td>Delete bird by id - <strong><font color="red">DELETE</font></strong></td>
        <td>/bird/delete/id</td>
        <td>
            id: <input id="birdDeleteId" value="1"/>
            <button type="button" onclick="RestDelete($('#birdDeleteId').val())">Try</button>
        </td>
    </tr>
</table>

<div class="card">
    <div class="card-title">
        <strong>RESPONSE</strong>
    </div>
    <div class="card-body" id='response'></div>

</div>
</body>
</html>
