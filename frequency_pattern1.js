let arr1 = [1, 2, 3, 4];
let arr2 = [16, 9, 4, 1];

// naive
let checkIfArrayAreEqual = () => {
    if( arr1.length !== arr2.length ){
        return false;
    }
    for( let i =0; i< arr1.length; i++ ){
        let indexExists = arr2.indexOf(arr1[i] ** 2);
        if( indexExists < 0 ){
            return false;
        }
        arr2.splice(indexExists, 1); 
    }
    return true;
}

//optimised
let checIfArraysAreEqual1 = () => {
    let frequenctArr1 = {};
    let frequenctArr2 = {};

    for( var key of arr1 ){
        frequenctArr1[key] = (frequenctArr1[key] || 0) + 1;
    }
    for( var key of arr2 ){
        frequenctArr2[key] = (frequenctArr2[key] || 0) + 1;
    }

    for( var key in frequenctArr1 ){
        if( !((key ** 2) in frequenctArr2)){
            return false;
        }

        if( frequenctArr1[key] !== frequenctArr2[key**2]){
            return false;
        }
    }
    return true;
}
console.log(checIfArraysAreEqual1())