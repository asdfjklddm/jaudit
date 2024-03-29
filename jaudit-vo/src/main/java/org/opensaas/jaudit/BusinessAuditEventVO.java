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
package org.opensaas.jaudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Default implementation and persistence mapping for an
 * {@link BusinessAuditEvent}.
 */
@Entity
@Table(name = "business_audit_events")
public class BusinessAuditEventVO extends AuditEventVO implements
        BusinessAuditEvent {

    private String _businessClass;

    private String _businessAction;

    /**
     * {@inheritDoc}
     */
    @Column(name = "business_class", length = 255, nullable = false)
    public String getBusinessClass() {
        return _businessClass;
    }

    /**
     * Sets the required business class.
     * 
     * @see #getBusinessClass()
     * 
     * @param businessClass
     *            the class to set.
     */
    public void setBusinessClass(String businessClass) {
        _businessClass = businessClass;
    }

    /**
     * {@inheritDoc}
     */
    @Column(name = "business_action", length = 1024)
    public String getBusinessAction() {
        return _businessAction;
    }

    /**
     * Sets the associated business action.
     * 
     * @see #getBusinessAction()
     * 
     * @param businessAction
     *            the action to set.
     */
    public void setBusinessAction(String businessAction) {
        _businessAction = businessAction;
    }

}
