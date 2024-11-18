public record Bug(String type) {
    public void bite(Creature creature) throws BugException {
        System.out.println(type + " кусает " + creature.getName() + "!");
        creature.changeState(State.BITTEN);
    }


}
