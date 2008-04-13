/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE
 * You may obtain a copy of the License at
 *
 *   http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opensaas.jaudit.dao.hibernate;

import java.util.Date;

import org.opensaas.jaudit.SessionRecordMutable;
import org.opensaas.jaudit.dao.SessionRecordDao;

/**
 * Default hibernate implementation of {@link SessionRecordDao}.
 */
public class SessionRecordDaoHibernate extends
        GenericDaoHibernate<SessionRecordMutable, String> implements
        SessionRecordDao {

    /**
     * Required constructor.
     * 
     * @param type
     *            the type we are managing.
     */
    public SessionRecordDaoHibernate(Class<SessionRecordMutable> type) {
        super(type);
    }

    /**
     * {@inheritDoc}
     */
    public void updateEndedTs(SessionRecordMutable sessionRecord, Date endedTs) {
        if (sessionRecord == null) {
            throw new IllegalArgumentException(
                    "Session record must not be null.");
        }

        SessionRecordMutable sr = read(sessionRecord.getId());
        if (sr == null) {
            throw new IllegalArgumentException(
                    "Session record does not exist in persistence.");
        }

        sr.setEndedTs(endedTs);

        getSession().save(sr);
    }
}
