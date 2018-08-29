import React, {Component} from 'react';
import Keycloak from 'keycloak-js';

class Protected extends Component {

    constructor(props) {
        super(props);
        this.state = {keycloak: null, authenticated: false};
    }

    componentDidMount() {
        const keycloak = Keycloak('/config/keycloak.json');
        keycloak.init({ onLoad: 'login-required' }).then(authenticated => {
            this.setState({ keycloak: keycloak, authenticated: authenticated })
        })
    }

    render() {
        if (this.state.keycloak) {
            if (this.state.authenticated) return (
                <div className="App-intro">
                    <p>
                        This is a protected area.<br />
                        Only authenticated users can access it.
                    </p>
                </div>
            ); else return ( <div>Sorry, but you are not authenticated.</div> )
        }
        return (
            <div></div>
        );
    }
}

export default Protected;
