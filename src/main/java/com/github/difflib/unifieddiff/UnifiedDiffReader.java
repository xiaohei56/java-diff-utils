import java.util.Objects;
    static final Pattern TIMESTAMP_REGEXP = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}[T ]\\d{2}:\\d{2}:\\d{2}\\.\\d{3,})");
    private final UnifiedDiffLine LINE_NORMAL = new UnifiedDiffLine("^\\s", this::processNormalLine);
    private final UnifiedDiffLine LINE_ADD = new UnifiedDiffLine("^\\+", this::processAddLine);
                initFileIfNecessary();
                while (!CHUNK.validLine(line)) {
                    if (processLine(line, DIFF_COMMAND, INDEX, FROM_FILE, TO_FILE) == false) {
                        throw new UnifiedDiffParserException("expected file start line not found");
                    }
                    line = READER.readLine();
            }
            processLine(line, CHUNK);
            while ((line = READER.readLine()) != null) {
                if (processLine(line, LINE_NORMAL, LINE_ADD, LINE_DEL) == false) {
                    throw new UnifiedDiffParserException("expected data line not found");
                }
                if (originalTxt.size() == old_size && revisedTxt.size() == new_size) {
                    finalizeChunk();
                    break;
            if (line == null || line.startsWith("--")) {
                break;
            }
        if (READER.ready()) {
            String tailTxt = "";
            while (READER.ready()) {
                tailTxt += READER.readLine() + "\n";
            }
            data.setTailTxt(tailTxt);
        //throw new UnifiedDiffParserException("parsing error at line " + line);
            throw new IllegalStateException();
        actualFile = null;
        //initFileIfNecessary();
    private int old_size;
    private int new_size;
        // finalizeChunk();
        old_ln = toInteger(match, 1, 1);
        old_size = toInteger(match, 2, 0);
        new_ln = toInteger(match, 3, 1);
        new_size = toInteger(match, 4, 0);
    private static Integer toInteger(MatchResult match, int group, int defValue) throws NumberFormatException {
        return Integer.valueOf(Objects.toString(match.group(group), "" + defValue));
    }

        //initFileIfNecessary();
        //initFileIfNecessary();
        actualFile.setFromTimestamp(extractTimestamp(line));
        //initFileIfNecessary();
        actualFile.setToTimestamp(extractTimestamp(line));
    private String extractFileName(String _line) {
        Matcher matcher = TIMESTAMP_REGEXP.matcher(_line);
        String line = _line;
        if (matcher.find()) {
            line = line.substring(1, matcher.start());
        }
        return line.substring(4).replaceFirst("^(a|b)\\/", "")
                .replace(TIMESTAMP_REGEXP.toString(), "").trim();
    }

    private String extractTimestamp(String line) {
        Matcher matcher = TIMESTAMP_REGEXP.matcher(line);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;