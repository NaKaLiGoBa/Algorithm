let answer = 0;

function solution(numbers, target) {

    dfs(numbers, target,0, 0);
    return answer;
}

function dfs(numbers, target, current, count) {
    if (count === numbers.length) {
        if (current === target)
            answer++;
        return;
    }

    dfs(numbers, target, current + numbers[count], count + 1)
    dfs(numbers, target, current - numbers[count], count + 1)

}

