<form>
    <nav class="indigo">
        <div class="nav-wrapper">
            <a href="/login" class="most-left-nav-element">Online Bank</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="most-right-nav-element">
                    <select name="language" onchange="submit()">
                        <option value="en_US" ${language == 'en_US' ? 'selected' : ''}><fmt:message key="language.english"/></option>
                        <option value="fr_FR" ${language == 'fr_FR' ? 'selected' : ''}><fmt:message key="language.french"/></option>
                    </select>
                </li>
            </ul>
        </div>
    </nav>
</form>
