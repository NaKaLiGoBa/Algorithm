import sys
input = sys.stdin.readline

string = input().rstrip()
word_stack = []
tag = False
res = ''

for s in string:
    # 공백이면 word_stack 비움
    if s == " ":
        while word_stack:
            res += word_stack.pop()
        res += s

    # 태그 안 단어는 뒤집지 않음
    elif s == "<":
        while word_stack:
            res += word_stack.pop()
        tag = True
        res += s

    elif s == ">":
        tag = False
        res += s

    elif tag:
        res += s

    # 태그 밖 단어는 뒤집음
    else:
        word_stack.append(s)

    # print(res, tag)

# 출력
while word_stack:
    res += word_stack.pop()
print(res)