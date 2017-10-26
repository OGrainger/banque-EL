<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Online Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <form class="form-inline my-4 my-lg-0">
                <select id="language" name="language" onchange="submit()" class="form-control">
                    <option value="en_US" ${language == 'en_US' ? 'selected' : ''}><fmt:message key="language.english"/></option>
                    <option value="fr_FR" ${language == 'fr_FR' ? 'selected' : ''}><fmt:message key="language.french"/></option>
                </select>
            </form>
        </ul>
    </div>
</nav>
