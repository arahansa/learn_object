package code_spitz.movie;

/**
 *  오디언스 생태계에서 관련되어있는 부분을 방패역할
 *  티켓오피스, 씨어터는 안전하게
 *
 *  어디언스가 변화하면?
 *  시즌이벤트가 생기면?
 *
 *  변할 것같은 부분만 따로 파일로 만들어야지~
 */
public class TicketSeller {
    private TicketOffice ticketOffice;
    public void setTicketOffice(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    /**
     * 트랜잭션이 성립. 셀러와 오디언스중 누가 갑? 누가 목마른 사슴?
     * 오디언스가 표를 원하기 때문에 을이다.
     * 갑은 셀러다. 표를 줄수도 있고 안 줄수도 있고
     * @param audience
     * @return
     */
    public Ticket getTicket(Audience audience){
        Ticket ticket = Ticket.EMPTY;
        if(audience.getInvitation() != Invitation.EMPTY){
            ticket = ticketOffice.getTicketWithFee();
            if(ticket != Ticket.EMPTY) audience.removeInvitation();
        // 재산을 전부 까진 않지만 500원은 있다고 말을 해야함.
        }else if(audience.hasAmount(ticketOffice.getTicketPrice())){
            ticket = ticketOffice.getTicketWithFee();
            if(ticket != Ticket.EMPTY) audience.minusAmount(ticketOffice.getTicketPrice());
        }
        return ticket;
    }
}
