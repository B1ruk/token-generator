import {useState} from "react";
import {validateTokenApi} from "../../api/TokenApi";

export const TokenValidator = () => {
    const [token, setToken] = useState();
    const [loading, setLoading] = useState(false);
    const [isValidToken, setIsValidToken] = useState(0);

    const validateToken = () => {
        if (token) {
            setLoading(true);
            validateTokenApi(token, setLoading, setIsValidToken);
        }
    }
    return (
        <div className='column'>
            <h3>Validator</h3>
            <hr/>
            <div>
                <input type="text" onChange={(e) => setToken(e.target.value)}/>
            </div>
            <div>
                <input className="button-primary button-outline" type="submit" value="validate"
                       onClick={() => validateToken()} disabled={loading}/>
                <div>
                    {(isValidToken !== 0) &&
                        <h6>{(isValidToken) ? <p>The Token is valid</p> : <p>Invalid Token</p>}
                        </h6>}
                </div>
            </div>
        </div>
    );
}
