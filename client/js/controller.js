function getPrice(){
    $.ajax({
    url:'mock.json',
    dataType:'json',
    type: 'get',
    cache:false,
    success:function (data) {
        $(data).each(function (index,value) {
            document.getElementById('price-ios').innerHTML = value.ios;
            document.getElementById('price-android').innerHTML = 'מחיר: '+ value.android;
        });
    }
});
}



function BuyProduct () {

    var ios = document.getElementById("ios-number");
    var iosNumber = Number(ios.options[ios.selectedIndex].value);

    var android = document.getElementById("android-number");
    var androidNumber = Number(android.options[android.selectedIndex].value);

    console.log (androidNumber)
    var toatlIos;
    var totalAndroid;

    //75% off for ios and android
    if (iosNumber>1) {
        toatlIos = totalPriceDiscount("price-ios", iosNumber)
        console.log(toatlIos);
    }
    if (androidNumber>1){
        totalAndroid = totalPriceDiscount("price-android", androidNumber)
        console.log(totalAndroid);
    }
    else {
        var t=(totalPrice("price-ios",iosNumber)+totalPrice("price-android", androidNumber))
        console.log(t);
    }

    var toatal = toatlIos + totalAndroid;
    //console.log(toatal);

    //send the number of products to the server
    creatEndPoint(iosNumber,androidNumber);

}


function totalPriceDiscount(price,products) {
    var price = Number(document.getElementById(price).innerHTML);
    var discount =  0.75;
    var total = discount*(products-1)+price;
    return total
}

function totalPrice(price,products) {
    var price = Number(document.getElementById(price).innerHTML);
    var total =price*products;
    return total
}

function creatEndPoint(ios,android) {
    $.ajax({
        url:'mock.json',
        dataType:'json',
        type: 'post',
        data: {"ios":ios,"android":android},
        cache:false,
        success:function (data) {
        window.open('"'+data.checkouturl+'"');
        }
    });

}