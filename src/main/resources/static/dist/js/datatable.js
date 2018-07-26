/**
 * Created by Muhammed Atallah on 7/2/2018.
 */
$(document).ready(function () {
    var table = $('#dtl').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        paging: true,
        lengthChange: true,
        searching: true,
        ordering: true,
        info: true,
        autoWidth: true,
        pageLength: 15,
        select: true
    });
});
