package io.github.droidkaigi.confsched2022.data.announcement

import io.github.droidkaigi.confsched2022.model.Announcement
import io.github.droidkaigi.confsched2022.model.AnnouncementRepository
import io.github.droidkaigi.confsched2022.model.defaultLang
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

public class DataAnnouncementRepository(
    private val announcementsApi: AnnouncementsApi
) : AnnouncementRepository {
    override fun announcements(): Flow<PersistentList<Announcement>> {
        return callbackFlow {
            send(
                announcementsApi
                    .announcements(defaultLang().name.lowercase())
                    .toPersistentList()
            )
        }
    }
}
