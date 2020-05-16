let anag1 = "gurur";
let anag2 = "rguut";

anag1 = anag1.split("");
anag2 = anag2.split("");

const checkAnagram =() => {
    if( anag1.length !== anag2.length ){
        return false;
    }

    let anagObj1 = {};

    for( let key of anag1){
        anagObj1[key] = (anagObj1[key] || 0 ) + 1;
    }

    for( var i =0; i< anag2.length; i++ ){
        if( !anagObj1[anag2[i]]){
            return false;
        }
        anagObj1[anag2[i]] -= 1;
    }
    
    return true;
}

console.log(checkAnagram());
