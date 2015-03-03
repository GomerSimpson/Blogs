function getCurrentFormattedDate(){
    return formatDate(new Date());
}

function formatDate(date){
    var values = [ date.getDate(), date.getMonth() + 1 ];

    for( var id in values ) {
        values[ id ] = values[ id ].toString().replace( /^([0-9])$/, '0$1' );
    }

    return date.getFullYear()+'-'+values[ 1 ]+'-'+values[ 0 ];
}