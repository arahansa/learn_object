package code_spitz.movie;

public class Audience {
    private Ticket ticket = Ticket.EMPTY;
    private Invitation invitation = Invitation.EMPTY;
    private Long amount;

    public Audience(Long amount) {
        this.amount = amount;
    }

    public void buyTicket(TicketSeller seller){
        ticket = seller.getTicket(this);
    }

    /**
     * 셀러가 원하는 인터페이스 시작
     * @param amount
     * @return
     */

    boolean hasAmount(Long amount) {
        return this.amount >= amount;
    }

    boolean minusAmount(Long amount) {
        if(amount > this.amount) return false;
        this.amount -= amount;
        return true;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void removeInvitation() {
        invitation = Invitation.EMPTY;
    }

    /**
     * 셀러가 원하는 인터페이스 끝
     * @return
     */

    public void setInviation(Invitation invitation) {
        this.invitation = invitation;
    }

    public Ticket getTicket() {
        return ticket;
    }






}
