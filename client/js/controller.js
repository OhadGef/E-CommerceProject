var cart = []
var products={};

function getPrice(){
    $.ajax({
    url:'http://localhost:8081/buy-obd/get-prices',
    dataType:'json',
    type: 'GET',
    cache:false,
    success:function (data) {
        $(data).each(function (index,value) {
            products = value;
            console.log(value)
            document.getElementById('price-ios').innerHTML = value.ios;
            document.getElementById('price-android').innerHTML = 'מחיר: '+ value.android;
        });
    }
});
}



function BuyProduct () {

    var ios = document.getElementById("ios-number");
    var iosNumber = parseInt(ios.options[ios.selectedIndex].value);

    var android = document.getElementById("android-number");
    var androidNumber = parseInt(android.options[android.selectedIndex].value);

    var totalIos = 0;
    var totalAndroid = 0 ;
    var totalPrice = 0;

    var iosPrice = products.ios;
    var androidPrice = products.android;

    var totalNumber = androidNumber+iosNumber;
    console.log ("iosNumber:" +iosNumber)
    console.log ("androidNumber:" +androidNumber)
    console.log ("totalNumber:" +totalNumber)


    //75% off for ios and android
    for (let x=0;x<totalNumber;x++) {
        if (iosNumber>1) {
            totalIos =+ ((iosNumber-1)*iosPrice)*0.75+iosPrice;
        }
        if (androidNumber>1) {
            totalAndroid =+ ((androidNumber-1)*androidPrice)*0.75+androidPrice;
        }
        if (iosNumber==1){
            totalIos =+ iosPrice;
        }
        if (androidNumber==1){
            totalAndroid =+ androidPrice;
        }

    }
    totalPrice = totalIos+totalAndroid;

    console.log("totalAndroid:"+totalAndroid);
    console.log("totalIos:"+totalIos);
    console.log("totalPrice:"+totalPrice);


    //send the number of products to the server
    creatEndPoint(iosNumber,androidNumber);

}


function creatEndPoint(ios,android) {
    $.ajax({
        url:'http://localhost:8081/createEndPoint',
        dataType:'json',
        type: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({"ios":ios,"android":android}),
        success:function (data) {
            $(data).each(function (index,value) {
                console.log(value)
            });
        }
    });

}