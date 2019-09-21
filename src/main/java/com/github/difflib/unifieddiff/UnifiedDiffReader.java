    private final UnifiedDiffLine[] MAIN_PARSER_RULES = new UnifiedDiffLine[]{
        new UnifiedDiffLine(true, "^diff\\s", this::processDiff),
        new UnifiedDiffLine(true, "^index\\s[\\da-zA-Z]+\\.\\.[\\da-zA-Z]+(\\s(\\d+))?$", this::processIndex),
        new UnifiedDiffLine(true, "^---\\s", this::processFromFile),
        new UnifiedDiffLine(true, "^\\+\\+\\+\\s", this::processToFile),
        new UnifiedDiffLine(false, UNIFIED_DIFF_CHUNK_REGEXP, this::processChunk),
        new UnifiedDiffLine("^\\s+", this::processNormalLine),
        new UnifiedDiffLine("^-", this::processDelLine),
        new UnifiedDiffLine("^+", this::processAddLine)
    };
        boolean header = true;
        String tailTxt = "";
            String line = READER.readLine();
            if (line.matches("--\\s*")) {
                LOG.log(Level.INFO, "parsing line {0}", line);
                if (processLine(header, line) == false) {
                    if (header) {
                        headerTxt += line + "\n";
                    } else {
                        break;
                    }
                } else {
                    if (header) {
                        header = false;
                        data.setHeader(headerTxt);
        finalizeChunk();

        while (READER.ready()) {
            tailTxt += READER.readLine() + "\n";
        data.setTailTxt(tailTxt);
    private boolean processLine(boolean header, String line) throws UnifiedDiffParserException {
        for (UnifiedDiffLine rule : MAIN_PARSER_RULES) {
            if (header && rule.isStopsHeaderParsing() || !header) {
                if (rule.processLine(line)) {
                    LOG.info("  >>> processed rule " + rule.toString());
                    return true;
                }
            finalizeChunk();
            actualFile = null;
        initFileIfNecessary();
        finalizeChunk();
        old_ln = match.group(1) == null ? 1 : Integer.parseInt(match.group(1));
        new_ln = match.group(3) == null ? 1 : Integer.parseInt(match.group(3));
        initFileIfNecessary();
        initFileIfNecessary();
        initFileIfNecessary();
    private String extractFileName(String line) {
        return line.substring(4).replaceFirst("^(a|b)\\/", "");
    class UnifiedDiffLine {