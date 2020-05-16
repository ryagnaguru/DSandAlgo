const arr = [2, 6, 9, 2, 1, 8, 5, 6, 3, 20, 21];
const subset = 3;

//naive
const maxSumOfSubsetArrNaive = () => {
    let sum = -Infinity;
    for( var i=0; i<=arr.length-(subset); i++){
        let temp = 0;
        for( var j = i; j< subset+i; j++ ){
            temp += arr[j];
        }
        if( temp > sum ){
            sum = temp;
        }
    }
    console.log(sum);
}

const maxSumOfSubsetArr = () => {
   let tempSum = 0;
   let maxSum = 0;
   for( var i=0; i<subset; i++ ){
      tempSum += arr[i];
   }

   maxSum= tempSum;
   for( var j=subset; j<arr.length; j++){
       tempSum = (tempSum-arr[j-subset]) + arr[j];
       maxSum = Math.max(tempSum, maxSum);
   }
   console.log(maxSum);
}

maxSumOfSubsetArr();