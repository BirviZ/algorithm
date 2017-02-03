import random

def getNumber():
    num = random.randint(0, 36)

    if num != 0:
        num = (num % 2) * 2 - 1

    return num

#Define constants
ROUNDS = 1000
RED = 1
BLACK = -1
ZERO = 0

#init variables
zeroes = 0
blacks = 0
reds = 0
maxZeroSequence = 0
maxRedSequence = 0
maxBlackSequence = 0

container = getNumber()

#Init counter
count = 0

#Count sequences
for i in range(ROUNDS):

    #Count red sequence
    if container == RED:
        while container == RED:
            reds += 1
            count += 1
            i += 1
            if i == ROUNDS:
                break
            container = getNumber()
        
            if count > maxRedSequence:
                maxRedSequence = count

    #Count black sequence
    elif container == BLACK:
        while container == BLACK:
            blacks += 1
            count += 1
            i += 1
            if i == ROUNDS:
                break
            container = getNumber()
        
        if count > maxBlackSequence:
            maxBlackSequence = count

    #count zero sequence
    elif container == ZERO:
        while container == ZERO:
            zeroes += 1
            count += 1
            i += 1
            if i == ROUNDS:
                break
            container = getNumber()
        
        if count > maxZeroSequence:
            maxZeroSequence = count
        
    count = 0
    i -= 1
    
#Result output
text = "-----------------------------------\n"

text += "Reds:\t\t\t{}\n".format(str(reds))
text += "Maximum sequence: \t{}\n\n".format(str(maxRedSequence))

text += "Blacks:\t\t\t{}\n".format(str(blacks))
text += "Maximum sequence: \t{}\n\n".format(str(maxBlackSequence))

text += "Zeroes:\t\t\t{}\n".format(str(zeroes))
text += "Maximum sequence: \t{}\n\n".format(str(maxZeroSequence))

print(text)
