package module5

import java.util.*

class Backend {
    private var sold = arrayOf<Ticket>()

    fun getSoldTicketsCount() = sold.size

    private fun sellTicket(ticket: Ticket) {
        sold += ticket
        println("Backend:\n  LOG:\n    Пользователь ${ticket.buyer} купил билет на фильм \"${ticket.filmName}\"; начало: ${Date(ticket.dateTimeBegin)}; место ${ticket.place}")
    }

    fun getPacket(packet: Packet) {
        when (packet.type) {
            PacketType.C2S.BUY_TICKET -> sellTicket((packet as PacketC2SBuyTicket).ticket)
        }
    }
}

data class Ticket(val buyer: String, val filmName: String, val place: String, val dateTimeBegin: Long)

abstract class User(val username: String) {
    abstract fun buyTicket(filmName: String, dateTimeBegin: Long, vararg places: String): Array<Ticket>
}

class UserService(username: String, private val packetManager: PacketManager) : User(username) {
    override fun buyTicket(filmName: String, dateTimeBegin: Long, vararg places: String): Array<Ticket> {
        val ticketTemplate = Ticket(username, filmName, "", dateTimeBegin)
        var arrayTickets = arrayOf<Ticket>()
        for (place in places) {
            val ticket = ticketTemplate.copy(place = place)
            packetManager.sendPacket(PacketC2SBuyTicket(ticket))
            arrayTickets += ticket
        }
        return arrayTickets
    }
}

data class PacketManager(private val backend: Backend) {
    fun sendPacket(packet: Packet) {
        backend.getPacket(packet)
    }
}

abstract class Packet(val type: Int)

data class PacketC2SBuyTicket(val ticket: Ticket) : Packet(PacketType.C2S.BUY_TICKET)

class PacketType {
    class C2S {
        companion object {  // я не знаю что это такое, но мне нужна статика. IDE подсказала так
            const val BUY_TICKET: Int = 0
        }
    }
}

fun main() {
    val backend = Backend()
    val packetManager = PacketManager(backend)
    val user: User = UserService("mrfix1033", packetManager)
    println("Backend:\n  Билетов продано - ${backend.getSoldTicketsCount()}")
    val tickets = user.buyTicket("Пассажиры (2016)", 1721154000000, "H12", "H13", "H14", "H15")
    println("User:\n  Я купил билеты:")
    for (ticket in tickets)
        println("    $ticket")
    println("Backend:\n  Билетов продано - ${backend.getSoldTicketsCount()}")
}