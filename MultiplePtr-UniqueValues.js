let arr = [1,2,3,4,4];


const findUniqueCount = () => {
    let count = 1;
    let i=0, j =1;
    while( i < j && j < arr.length ){
        if( arr[i] !== arr[j]){
            count++;
            i = j;
        }
        j++;
    }
    return count;
}

console.log(findUniqueCount());