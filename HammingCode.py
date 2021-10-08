class Hamming:
    def __init__(self):
        file = open("data.txt", "r")
        self.message = file.readline()
        file.close()
        print("input is", '"{}"'.format(self.message))

    def convertToBinary(self):
        self.ascii = []
        for i in self.message:
            x = (bin(ord(i)))[2:]
            self.ascii.append(("0" * (7 - len(x))) + x)

    def convertToHammingCode(self):
        for i in range(len(self.ascii)):
            x = self.ascii[i]
            x = x[:3] + "0" + x[3:6] + "0" + x[6] + "00"
            if (x[-1:-12:-2]).count("1") % 2 != 0:
                x = x[:10] + "1"
            if (x[-2:-12:-4] + x[-3:-12:-4]).count("1") % 2 != 0:
                x = x[:9] + "1" + x[10]
            if (x[-4:-8:-1]).count("1") % 2 != 0:
                x = x[-11:-4] + "1" + x[-3:]
            if (x[-8:-12:-1]).count("1") % 2 != 0:
                x = x[-11:-8] + "1" + x[-7:]
            self.ascii[i] = x

    def checkHammingCode(self):
        for i in range(len(self.ascii)):
            x = self.ascii[i]
            if (
                ((x[-8:-12:-1]).count("1") % 2 != 0)
                or ((x[-4:-8:-1]).count("1") % 2 != 0)
                or ((x[-2:-12:-4] + x[-3:-12:-4]).count("1") % 2 != 0)
                or ((x[-1:-12:-2]).count("1") % 2 != 0)
            ):
                print("Message has noise")
                break
        else:
            print("Message is recieved noise free")

    def printRecievedMessage(self):
        for i in self.ascii:
            x = i[-11:-8] + i[-7:-4] + i[-3]
            print(chr(int(x, 2)), end="")
        print('"')


if __name__ == "__main__":
    h = Hamming()
    h.convertToBinary()
    h.convertToHammingCode()
    h.checkHammingCode()
    print('Message recieved after using hamming code is: "', end="")
    h.printRecievedMessage()