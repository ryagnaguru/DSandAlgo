const arr = [-3, -2, -1, 0, 3, 4, 5, 6];
const expec = 6;


const findSumPairInArray = ( arr, expec) => {
    let i =0;
    let j = arr.length - 1;

    while(i < j){
        const sum = arr[i]+ arr[j];
        if( sum === expec){
            return ([arr[i], arr[j]]);
        }else if( sum > expec ){
            j--;
        }else{
            i++;
        }
    }
}

console.log(findSumPairInArray(arr, expec));
