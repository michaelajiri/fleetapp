$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('#txtIdEdit').val(client.id);
            $('#txtNameEdit').val(client.name);
            $('#txtAddressEdit').val(client.address);
            $('#txtPhoneEdit').val(client.phone);
            $('#txtEmailEdit').val(client.email);
            $('#ddlCountryEdit').val(client.countryid);
            $('#txtCityEdit').val(client.city);
            $('#txtDetailsEdit').val(client.details);
        });
        $('#editModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});
