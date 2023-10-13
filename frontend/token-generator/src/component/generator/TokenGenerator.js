import {useState} from "react";
import {generateTokenApi} from "../../api/TokenApi";

export const TokenGenerator = () => {
    const [loading, setLoading] = useState(false);
    const [token, setToken] = useState('');
    const [digit, setDigit] = useState(null);

    const generateToken = () => {
        if (digit) {
            setLoading(false);
            generateTokenApi(digit, setLoading, setToken);
        }
    };

    return (
        <div className='column'>
            <h3>Token Generator</h3>
            <hr/>
            <div>
                <div>
                    <input type="number" max={99999} onChange={(e) => setDigit(e.target.value)}/>
                </div>
                <button className="button button-outline" onClick={() => generateToken()} disabled={loading}>Generate
                    Token
                </button>
            </div>
            <div>
                <h2 className="mt-1">{token ? token : 'XXXX-XXXX-XXXX-XXXX'}</h2>
            </div>
        </div>
    );
}
