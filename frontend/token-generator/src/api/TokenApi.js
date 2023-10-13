import axios from "axios";

export const ApiUrl = 'http://localhost:7000';

export function generateTokenApi(digits, setLoading, setData) {
    axios.get(`${ApiUrl}/TokenGeneratorResource/generate?digits=${digits}`)
        .then(response => {
            if (response.status == 200) {
                setData(response.data);
            }
        }).finally(() => setLoading(false));
}

export function validateTokenApi(token, setLoading, setData) {
    axios.get(`${ApiUrl}/validatorResource/validateToken?token=${token}`)
        .then(response => {
            if (response.status == 200) {
                setData(response.data);
            }
        }).finally(() => setLoading(false));
}
