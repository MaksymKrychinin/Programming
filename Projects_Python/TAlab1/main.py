n = int(input())
b = ""
while n > 0:
    b = str(n % 2) + b
    n = n // 2

output = ""
for i in range(0, len(b)):
    if b[i] == "1":
        output += "0"
    elif b[i] == "0":
        output += "1"
temp = 0
for i in range(0, len(output)):
    temp = temp + int(output[i]) * 2**(len(output) - i - 1)
print(temp)