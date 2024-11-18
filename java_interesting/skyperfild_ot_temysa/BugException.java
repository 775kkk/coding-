public class BugException extends Exception {
        @Override
        public String getMessage() {
            return "Насекомое не смогло укусить!";
        }
}
