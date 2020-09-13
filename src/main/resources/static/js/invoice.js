$(document).ready(function() {
    $('.table .editButton').on('click', function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(invoice, status){
            $('#idEdit').val(invoice.id);
            $('#ddlClientEdit').val(invoice.clientid);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#remarksEdit').val(invoice.remarks);
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