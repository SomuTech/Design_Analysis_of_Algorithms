from HammingCode import Hamming
import random as r

class Correction:
    def __init__(self):
        self.h = Hamming()
        self.h.convertToBinary()
        self.h.convertToHammingCode()

    def createError(self):
        letterIndex = r.randint(0, len(self.h.ascii)-1)
        x = self.h.ascii[letterIndex]
        bitIndex = r.randint(0, len(x) - 1)
        x = x[:bitIndex] + str(int(x[bitIndex])^1) + x[bitIndex + 1 :]
        self.h.ascii[letterIndex] = x

    def correctError(self):
        errorIndex  = -1
        x = ''
        for i in range(len(self.h.ascii)):
            x = self.h.ascii[i]
            if (
                ((x[-8:-12:-1]).count("1") % 2 != 0)
                or ((x[-4:-8:-1]).count("1") % 2 != 0)
                or ((x[-2:-12:-4] + x[-3:-12:-4]).count("1") % 2 != 0)
                or ((x[-1:-12:-2]).count("1") % 2 != 0)
            ):
                errorIndex = i
                break
        else:
            print("Message is already corrected")

        errorBit = '0000'
        if (x[-8:-12:-1]).count("1") % 2 != 0:
            errorBit = '1' + errorBit[1:]
        if (x[-4:-8:-1]).count("1") % 2 != 0:
            errorBit = errorBit[:1] + '1' +errorBit[2:]
        if (x[-2:-12:-4] + x[-3:-12:-4]).count("1") % 2 != 0:
            errorBit = errorBit[:2]+'1'+errorBit[3:]
        if (x[-1:-12:-2]).count("1") % 2 != 0:
            errorBit = errorBit[:3] + '1'
        index = int(errorBit,2)
        x = x[:11-index] + str(int(x[-index])^1) + x[11-index+1:]
        self.h.ascii[errorIndex] = x

if __name__ == "__main__":
    c = Correction()
    c.createError()
    c.h.checkHammingCode()
    print('Message with Noise is: "', end="")
    c.h.printRecievedMessage()
    c.correctError()
    print('Message after correcting  is: "',end="")
    c.h.printRecievedMessage()