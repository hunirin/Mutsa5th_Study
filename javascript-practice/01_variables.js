/*
let
const
var
 */

// 데이터의 형식을 따지지 않는 변수
let foo = 'a let variable'
console.log(foo)
// let으로 선언한 변수는 재할당이 가능하다
foo = 'let variables can be reallocated'
console.log(foo)
// 다른 타입도 재할당 되긴하나 권장되지 않음
foo = 10
console.log(foo)

// const
// 불변하는 변수
const bar = 'a const variable'
console.log(bar)
// const로 선언한 변수는 재할당이 불가
// java의 final과 비슷한 역할


// var
// let과 유사하게 동작
var baz = 'a var variable'
console.log(baz)
baz = `var can be assigned again`


// 호이스팅(hoisting)

console.log(notHoisted) // 오류
let notHoisted = 'let variable is not hoisted'

// 아래쪽 선언한 변수들을 코드 최상단에서 우선 선언하도록
// 코드가 변경되어, 실제 값을 할당 이전에 참조가 가능해지는 현상
console.log(hoisted)
var hoisted = 'var variable is hoisted'

// 호이스팅은 논리적 흐름을 깨뜨리기 때문에 더이상 권장되지 않음




















