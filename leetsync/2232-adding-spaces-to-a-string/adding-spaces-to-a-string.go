func addSpaces(s string, spaces []int) string {
    resultString:=strings.Builder{}
    resultString.Grow(len(s)+len(spaces))

    lastPos:=0
    for _, space:= range spaces {
        resultString.WriteString(s[lastPos:space])
        resultString.WriteByte(' ')
        lastPos = space
    }
    resultString.WriteString(s[lastPos:])
    return resultString.String()
}