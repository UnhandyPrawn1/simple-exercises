# Mad Libs Reader
# author: Alex Lobley
# Based on tutorial from https://www.youtube.com/watch?v=8ext9G7xspg&t=100s

TRUE_RESPONSES = ['y', 'yes', '1', 'true']
FALSE_RESPONSES = ['n', 'no', '0', 'false']
ERROR_COUNTS = 3

# Last method to allow for clean restart
def askForRetry():
    exitAttempts = ERROR_COUNTS
    while exitAttempts > 0:
        match input("Try again?").lower():
            case item if item in TRUE_RESPONSES:
                return True
            case item if item in FALSE_RESPONSES:
                return False
            case _:
                exitAttempts -= 1
                print("Response not understood, exiting in " + str(exitAttempts) + " attempts")
    print("Response not understood, exiting...")

# Handles inserting user input to word list
def changeWords(wordReplacements):
    print("Enter words of the following types: ")
    index = 0
    while index < len(wordReplacements):
        wordReplacements[index] = input(wordReplacements[index] + ": ")
        index += 1

# Extract remainder of text file after replacements
def copyFileText(file, posInFile):
    file.seek(posInFile)
    return file.read()

# Extract word replacements from file
def readFileParameters(file):
    currentLine = file.readline()
    while currentLine != '\n':
        wordReplacements.append(currentLine.rstrip('\n'))
        currentLine = file.readline()
    return file.tell()


# Inserts user replacements into text
def runReplacements(text):
    index = 0
    while index < len(wordReplacements):
        text = text.replace("*", wordReplacements[index], 1)
        index += 1
    return text
    
# main()
retry = True
fileErrorsLeft = ERROR_COUNTS

# TODO: #1 Needs to set dir to consistent location
# https://stackoverflow.com/questions/1432924/python-change-the-scripts-working-directory-to-the-scripts-own-directory

while retry & fileErrorsLeft > 0:
    wordReplacements = []
    try:
        
        with open(input("Please select Madlibs file to use: ") + ".txt", "r", encoding='utf8') as textChosen:
            
            posInFile = readFileParameters(textChosen)
            originalText = copyFileText(textChosen, posInFile)

            changeWords(wordReplacements)

            finalOutput = runReplacements(originalText)
            print(finalOutput)
            print()

            retry = askForRetry()            
                
    except FileNotFoundError:
        # TODO #2 Restrict restarts or allow exit if failing
        #fileErrorsLeft -=1
        print()
        print("That story could not be found, please try again!")
        print("Reminder: Text must be character-perfect without file extension")
        print("Program will exit after " + str(fileErrorsLeft) + " more attempts")
        print()
    # except:
    #     retry = False
    #     print("An unknown error occurred, exiting...")