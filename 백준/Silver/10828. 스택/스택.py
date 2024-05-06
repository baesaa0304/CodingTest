import sys
input=sys.stdin.readline

N = int(input())
stack = []

def push(M) :
        stack.append(M)

def pop():
    if len(stack) != 0:
        print(stack.pop())
    else : 
        print(-1)

def size():
    print(len(stack))

def top():
    if len(stack) != 0:
        print(stack[-1])
    else :
        print(-1)    

def empty():
    if len(stack) == 0:
        print(1)
    else:
        print(0)

for _ in range(N):
    command = input().split()
    if command[0]=='push':
        push(command[1])
    elif command[0]=='pop':
        pop()
    elif command[0]=='size':
        size()
    elif command[0]=='empty':
        empty()
    elif command[0]=='top':
        top()