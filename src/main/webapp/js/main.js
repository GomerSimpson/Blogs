function getCurrentFormattedDate(){
    return formatDate(new Date());
}

function formatDate(date){
    var values = [ date.getDate(), date.getMonth() + 1 ];

    for( var id in values ) {
        values[ id ] = values[ id ].toString().replace( /^([0-9])$/, '0$1' );
    }

    return date.getFullYear() + '-' + values[ 1 ] + '-' + values[ 0 ];
}


//init 2 datapickers(they are related to each other)
$(function() {
    $( "#fromDate" ).datepicker({
        showOtherMonths: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
            $( "#toDate" ).datepicker( "option", "minDate", selectedDate );
        }
    });

    $( "#toDate" ).datepicker({
        showOtherMonths: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
            $( "#fromDate" ).datepicker( "option", "maxDate", selectedDate );
        }
    });
});

//работа с всплывающими окнами(добавления записи и печати отчётов)

p = $('#addPopupOverlay');
r = $('#reportPopupOverlay');

$('#popup__toggle').click(function() {
    $('#main').hide();
    p.css('display', 'block');
});

$('#reportPopupToggle').click(function() {
    $('#main').hide();
    r.css('display', 'block');
});

p.click(function(event) {
    e = event || window.event;

    if (e.target == this) {
        $('#main').show();
        $(p).css('display', 'none');
    }
});

r.click(function(event) {
    e = event || window.event;

    if (e.target == this) {
        $('#main').show();
        $(r).css('display', 'none');
    }
});

$('#addPopupClose').click(function() {
    $('#main').show();
    p.css('display', 'none');
});

$('#reportPopupClose').click(function() {
    $('#main').show();
    r.css('display', 'none');
});

///////////////////////////////////

function trimFileName(name){
    return name.substring(6);
}