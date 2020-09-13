$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (supplier, status) {
            $('#txtIdEdit').val(supplier.id);
            $('#txtNameEdit').val(supplier.name);
            $('#txtAddressEdit').val(supplier.address);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#txtEmailEdit').val(supplier.email);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#txtCityEdit').val(supplier.city);
            $('#txtDetailsEdit').val(supplier.details);
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
